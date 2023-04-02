# This program demonstrates PLAYFAIR CIPHER.
# Only lowercase letters are allowed.
# Ex1: PT: meetmeafterthetogaparty  DEPTH: 3 CT: mmthgretefeteoaateartpy
plainText = input("Enter Plaintext: ")
depth = int(input("Enter Depth: "))

# creating matrix
m = []
for i in range(depth):
    m.append(['.'] * len(plainText))
i = 0
j = 0
d = 1
for c in plainText:
    m[i][j] = c
    if i == depth-1:
        d = -1
    elif i == 0:
        d = 1
    i += d
    j += 1
print("Matrix:")
for i in range(depth):
    print(m[i])

# ENCRYPTION
cipherText = ""
for i in range(depth):
    for j in range(len(plainText)):
        if(m[i][j] != '.'):
            cipherText += m[i][j]
print("\nCipher Text: ",cipherText)

# DECRYPTION
decryptedText = ""
i = 0
j = 0
for k in range(len(plainText)):
    decryptedText += m[i][j]
    if i == depth-1:
        d = -1
    elif i == 0:
        d = 1
    i += d
    j += 1
print("\nDecrypted Text: ",decryptedText)