nota = []
soma = 0

for i in range(5):
    nota.append(int(input('Qual a nota: ')))
    soma += nota[i]

mf = soma / len(nota)

print('A média final é: ', mf)


'''
nota = [1,2,10,8,5]
soma = sum(nota)
media = soma / len(nota)
print('A média é: ',media)
'''