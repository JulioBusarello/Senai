// --- Servidor
let logado = false;
let socket;

function connectServer(event) {
    event.preventDefault(); // Impede o envio do formulário

    const serverIp = document.getElementById('serverIp').value;
    const username = document.getElementById('username').value;

    socket = new WebSocket(`ws://${serverIp}:3000`);

    // Evento disparado quando a conexão é estabelecida
    socket.onopen = () => {
        socket.send(JSON.stringify({ type: 'login', username }));
        logado = true;
    };

    // Evento disparado quando uma mensagem é recebida do servidor
    socket.onmessage = (event) => {
        const data = JSON.parse(event.data);

        if (data.type === 'updateUsers') {
            const adversaryList = document.getElementById('adversaryList');
            adversaryList.innerHTML = ''; // Limpa a lista existente

            data.users.forEach((user) => {
                if (user.username != "allusers") {
                    const option = document.createElement('option');
                    option.value = user.username;
                    // Exibe nome do usuário seguido do IP
                    option.innerText = `${user.username} (${user.ip})`;
                    adversaryList.appendChild(option);
                }
            });
            const option = document.createElement('option');
            option.value = "Todos";
            option.innerText = "Todos";
            adversaryList.appendChild(option);
        }

        if (data.from && data.message) {
            const chat = document.getElementById('historic');
            chat.innerHTML += `<p><strong>${data.from}:</strong> ${data.message}</p>`;

            const partes = data.message.split(":");
            const linha = parseInt(partes[1].substring(1));
            const coluna = parseInt(partes[0].substring(1));
            const tiro = partes[2];

            //alert("Linha: " + linha + "\nColuna: " + coluna + "\nTIRO: " + tiro);

            if (tiro.includes('FOGO')) {
                paintShoot(linha, coluna, "F");
            } else if (tiro.includes('AGUA')) {
                paintShoot(linha, coluna, "A");
            } else if (tiro.includes('TIRO')) {
                checkBomb(linha, coluna, data.from);
            }
        }
    };

}

// --- Tabuleiro
const boardSize = 16;
const board = [];
const boardAdversary = [];

let esquadra = {
    submarino: { size: 1, count: 4, color: 'blue' },
    cruzador: { size: 2, count: 3, color: 'green' },
    hidroaviao: { size: 3, count: 5, color: 'red' },
    encouracado: { size: 4, count: 2, color: 'purple' },
    portaAvioes: { size: 5, count: 1, color: 'orange' }
};

let itemEsquadraAtual = "submarino";
const playerEsquadra = [];
let qtdItemEsquadra = [4, 3, 5, 2, 1];

let jogoIniciado = false;
let currentDirection = 'HORIZONTAL';

// Cria tabuleiro
function createBoard() {
    const boardContainer = document.getElementById('board');
    boardContainer.innerHTML = '';
    // Cria a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        board[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            cell.dataset.row = row;
            cell.dataset.col = col;

            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col);
                cell.classList.add('title');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row;
                cell.classList.add('title');
            }

            cell.addEventListener('mousedown', (event) => onCellClick(event, row, col));
            board[row].push(cell);
            boardContainer.appendChild(cell);
        }
    }
}

// Mudar barco atual
function changeItem() {
    const shipOrder = ["submarino", "cruzador", "hidroaviao", "encouracado", "portaAvioes"];
    const currentIndex = shipOrder.indexOf(itemEsquadraAtual);

    if (logado) {
        itemEsquadraAtual = shipOrder[(currentIndex + 1) % shipOrder.length];
        alert(`Agora coloque o ${itemEsquadraAtual}.`);
    }
}

// Alterar direção do barco através do mouse
function onCellClick(event, row, col) {
    let qtd = esquadra[itemEsquadraAtual].count;

    if (logado) {
        if (event.button === 0) {
            currentDirection = "HORIZONTAL";
            //alert(currentDirection + "\nLinha: " + row + "\nColuna: " + col);
        } else if (event.button === 2) {
            currentDirection = "VERTICAL";
            //alert(currentDirection + "\nLinha: " + row + "\nColuna: " + col);
        }

        if (esquadra[itemEsquadraAtual].count === 0) {
            alert("Toda a esquadra já está posicionada.")
            return;
        } else {
            alert(currentDirection + ": " + "\nLinha: " + row + "\nColuna: " + col + "\n" + itemEsquadraAtual + "\n Posicionado 1 " + itemEsquadraAtual + " restam " + (qtd - 1));
            esquadra[itemEsquadraAtual].count--;
            placePart(row, col);
            if (esquadra[itemEsquadraAtual].count === 0) {
                changeItem();
            }
        }
    } else {
        alert('Você deve estar logado para usar o sistema!')
    }
}

// Colocar barco
function placePart(row, col) {
    const itemSize = esquadra[itemEsquadraAtual].size;
    const itemColor = esquadra[itemEsquadraAtual].color;
    const newItem = [];

    // Lógica para o hidroavião
    if (itemEsquadraAtual === "hidroaviao") {
        if (currentDirection === "HORIZONTAL") {
            if (col + 1 >= boardSize || row + 1 >= boardSize || col - 1 < 1 || row < 1) {
                alert("Não é possível colocar o hidroavião aqui.");

                esquadra[itemEsquadraAtual].count++;

                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }
            // Marca no tabuleiro como célula em uso
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship');  // Ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).classList.add('ship'); // Asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa direita
            // Pinta a cor do hidroavião
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor;  // Cor da ponta
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col - 1}"]`).style.backgroundColor = itemColor; // Cor da asa esquerda
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa direita

            newItem.push({ row, col }, { row: row + 1, col: col - 1 }, { row: row + 1, col: col + 1 });


        } else if (currentDirection === "VERTICAL") {
            if (row + 1 >= boardSize || row - 1 < 1 || col + 1 >= boardSize || col < 1) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            if (
                document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.contains('ship') ||
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + 1}"]`).classList.contains('ship')
            ) {
                alert("Não é possível colocar o hidroavião aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.add('ship'); // Ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).classList.add('ship'); // Asa inferior
            document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).style.backgroundColor = itemColor; // Cor da ponta
            document.querySelector(`.cell[data-row="${row - 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa superior
            document.querySelector(`.cell[data-row="${row + 1}"][data-col="${col + 1}"]`).style.backgroundColor = itemColor; // Cor da asa inferior
            newItem.push({ row, col }, { row: row - 1, col: col + 1 }, { row: row + 1, col: col + 1 });
        }
    }
    else if (itemEsquadraAtual === "submarino") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }

        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o submarino aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o submarino aqui.");

                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
    else if (itemEsquadraAtual === "cruzador") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o cruzador aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o cruzador aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
    else if (itemEsquadraAtual === "encouracado") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o encouraçado aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o encouraçado aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
    else if (itemEsquadraAtual === "portaAvioes") {
        if (currentDirection === "HORIZONTAL") {
            if (col + itemSize - 1 >= boardSize || col < 1 || row < 1) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row}"][data-col="${col + i}"]`).style.backgroundColor = itemColor;
                newItem.push({ row, col: col + i });
            }
        } else if (currentDirection === "VERTICAL") {
            if (row + itemSize - 1 >= boardSize || row < 1 || col < 1) {
                alert("Não é possível colocar o porta-aviões aqui.");
                esquadra[itemEsquadraAtual].count++;
                return;
            }

            for (let i = 0; i < itemSize; i++) {
                if (document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.contains('ship')) {
                    alert("Não é possível colocar o porta-aviões aqui.");
                    esquadra[itemEsquadraAtual].count++;
                    return;
                }
            }

            for (let i = 0; i < itemSize; i++) {
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).classList.add('ship');
                document.querySelector(`.cell[data-row="${row + i}"][data-col="${col}"]`).style.backgroundColor = itemColor;
                newItem.push({ row: row + i, col });
            }
        }
    }
}

function paintShoot(row, col, tiro) {
    const newBomb = [];
    const msgTiro = tiro;

    document.querySelector(`.cellAdversary[data-row="${row}"][data-col="${col}"]`).classList.add('tiro');
    const cell = document.querySelector(`.cellAdversary[data-row="${row}"][data-col="${col}"]`);
    if (cell) {
        if (msgTiro === 'F') {
            cell.style.backgroundColor = 'green';

        } else if (msgTiro === 'A') {
            cell.style.backgroundColor = 'gray';
        }
        //cell.innerHTML = `<p><strong>X</p>`;
    }

    else {
        alert("Célula não existe...")
    }

    newBomb.push({ row, col: col });
}

// --- Jogador 2
function createAdversaryBoard() {
    const boardContainer = document.getElementById('boardAdversary');
    boardContainer.innerHTML = '';
    // Cria a matriz 16x16 do tabuleiro
    for (let row = 0; row < boardSize; row++) {
        boardAdversary[row] = [];
        for (let col = 0; col < boardSize; col++) {
            const cell = document.createElement('div');
            cell.classList.add('cellAdversary');
            cell.dataset.row = row;
            cell.dataset.col = col;

            if (row === 0 && col > 0) {
                cell.textContent = String.fromCharCode(64 + col);
                cell.classList.add('titleAdversary');
            }
            if (col === 0 && row > 0) {
                cell.textContent = row;
                cell.classList.add('titleAdversary');
            }

            cell.addEventListener('mousedown', () => onCellClickShot(row, col));
            boardAdversary[row].push(cell);
            boardContainer.appendChild(cell);
        }
    }
}

function onCellClickShot(row, col) {
    if (logado) {
        if (row < 1 || col < 1) {
            alert("Não é possível efetuar um disparo fora do tabuleiro.");
        } else {
            const coordenateInput = document.getElementById('shooting');
            coordenateInput.value = `C${col}:L${row}`;
        }
    } else {
        alert('Você deve estar logado para usar o sistema!')
    }

}

function sendShooting(event) {
    event.preventDefault();

    const coordenates = document.getElementById('shooting').value;
    const toUser = document.getElementById('adversaryList').value;
    const username = document.getElementById('username').value;
    let adversary = document.getElementById('adversaryOficial');

    if (logado) {
        if (coordenates === '') {
            alert('Você deve selecionar uma coordenada.')
            return;
        }

        if(adversary.value === ""){
            adversary.value = toUser;
        }

        // Não exibe a mensagem para o próprio usuário
        if (adversary.value !== username) {
            const chat = document.getElementById('historic');
            chat.innerHTML += `<p><strong>Você</strong> para <strong>${adversary.value}:</strong> ${coordenates}:TIRO</p>`;
            chat.scrollTop = chat.scrollHeight;
        }

        socket.send(JSON.stringify({
            type: 'message',
            from: username,
            to: adversary.value,
            message: coordenates + ":TIRO"
        }));

        document.getElementById('shooting').value = '';

    } else {
        alert('Você deve estar logado para usar o sistema!')
    }
}


// Carregar tabuleiros
function loadBoards() {
    createBoard();
    createAdversaryBoard();
}

window.onload = () => loadBoards();

function disconnectServer() {
    if (socket) {
        // Evento disparado quando a conexão é fechada
        socket.close(); // Fecha a conexão WebSocket
        console.log("Desconectado do servidor");

        // Atualiza a interface, removendo a lista de usuários e chat
        const userList = document.getElementById('userList');
        userList.innerHTML = '';
        const chat = document.getElementById('chat');
        chat.innerHTML = `<p><strong>Você foi desconectado.</strong></p>`;

        logado = false;
    }
}

function checkBomb(row, col, returnFrom) {
    if (document.querySelector(`.cell[data-row="${row}"][data-col="${col}"]`).classList.contains('ship')) {
        infoShoot('C' + col + ':L' + row + ':FOGO', returnFrom);
        //alert("FOGO");
    } else {
        infoShoot('C' + col + ':L' + row + ':AGUA', returnFrom);
        //alert("AGUA");
    }
}

function infoShoot(msg, returnFrom) {
    const username = document.getElementById('username').value;
    const to = returnFrom;
    //const toUser = document.getElementById('adversaryList').value;

    socket.send(JSON.stringify({
        type: 'message',
        from: username,
        to: to,
        message: msg
    }));

    document.getElementById('shooting').value = '';
}