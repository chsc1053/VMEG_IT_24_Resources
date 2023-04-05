import numpy as np
plainText = input("Enter Plaintext: ")
key = input("Enter Key String: ")

l = []
i = 0
while i < len(plainText)-1:
    if(plainText[i]==plainText[i+1]):
        plainText = (plainText[:i+1] + "x" + plainText[i+1:])
    i+=1
if(len(plainText)%2!=0):
    plainText += "x"
print("\nModified Plain Text: ",plainText)

# Create matrix
alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
m = []
for i in range(5):
    m.append(['.'] * 5)
i = 0
j = 0
k = 0
while k < len(key):
    # add characters from key
    if key[k] not in m[0]+m[1]+m[2]+m[3]+m[4]:
        m[i][j] = key[k]
        if j == 4:
            i += 1
        j = (j + 1) % 5
    k += 1
k = 0
while k < len(alphabet):
    # add remaining characters from  alphabet
    if alphabet[k] not in m[0]+m[1]+m[2]+m[3]+m[4]:
        m[i][j] = alphabet[k]
        if j == 4:
            i += 1
        j = (j + 1) % 5
    k += 1
print("Matrix:\n",m)
mt = np.array(m).T.tolist()

# FUNCTION FOR ENCRYPTION & DECRYPTION
def encrypt_decrypt(p,action):
    arr = []
    for pi in range(len(p)):
        # for each pair
        flag = True
        found0 = False
        found1 = False
        p0i = -1
        p0j = -1
        p1i = -1
        p1j = -1
        i = 0
        while not (found0 and found1):
            # get indices of the pair characters
            if p[pi][0] in m[i]:
                p0i = i
                p0j = m[i].index(p[pi][0])
                found0 = True
            if p[pi][1] in m[i]:
                p1i = i
                p1j = m[i].index(p[pi][1])
                found1 = True
            i += 1
        if p0i == p1i:
            # same row
            if action == 'e':
                arr.append([m[p0i][(p0j+1) % 5], m[p0i][(p1j+1) % 5]])
            if action == 'd':
                arr.append([m[p0i][(p0j-1) % 5], m[p0i][(p1j-1) % 5]])
            flag = False
        elif p0j == p1j:
            # same column
            if action == 'e':
                arr.append([mt[p0j][(p0i+1) % 5], mt[p0j][(p1i+1) % 5]])
            if action == 'd':
                arr.append([mt[p0j][(p0i-1) % 5], mt[p0j][(p1i-1) % 5]])
            flag = False
        if(flag):
            # diff row & col
            arr.append([m[p0i][p1j], m[p1i][p0j]])
    return arr

# Create plain text pairs
k = 0
p = []
for i in range(int(len(plainText)/2)):
    p.append([plainText[k],plainText[k+1]])
    k += 2

# ENCRYPTION
e = encrypt_decrypt(p,'e')
ct = ""
for i in e:
    ct+=(i[0]+i[1])
print("\nCipher Text: ",ct)

# DECRYPTION
d = encrypt_decrypt(e,'d')
dt = ""
for i in d:
    dt+=(i[0]+i[1])
print("\nDecrypted Text: ",dt)