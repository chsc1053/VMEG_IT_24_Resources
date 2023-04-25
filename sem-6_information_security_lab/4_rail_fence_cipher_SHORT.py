pt = input("Enter Plaintext: ")
depth = int(input("Enter Depth: "))

m = []
for i in range(depth):
    m.append(['.'] * len(pt))
i = 0
j = 0
d = 1
for c in pt:
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
ct = ""
for i in range(depth):
    for j in range(len(pt)):
        if(m[i][j] != '.'):
            ct += m[i][j]
print("\nCipher Text: ",ct)

# DECRYPTION
dt = ""
i = 0
j = 0
for k in range(len(pt)):
    dt += m[i][j]
    if i == depth-1:
        d = -1
    elif i == 0:
        d = 1
    i += d
    j += 1
print("\nDecrypted Text: ",dt)