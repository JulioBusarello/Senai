peso = int(input('Informe seu peso (Em KG): '))
altura = float(input('Informe sua altura (Em metros): '))

imc = peso / (altura * altura)

print('Seu IMC é:', imc)

status = ""

if imc <= 16.9:
    status = 'Muito abaixo do peso'
elif imc <= 18.4:
    status = 'Abaixo do peso'
elif imc <= 24.9:
    status = 'Peso normal'
elif imc <= 29.9:
    status = 'Acima do peso'
elif imc <= 34.9:
    status = 'Obesidade grau I'
elif imc <= 40.0:
    status = 'Obesidade grau II'
elif imc > 40.0:
    status = 'Obesidade grau III'

print("Você está", status)
