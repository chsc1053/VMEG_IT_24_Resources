import numpy as np
pt = input("Enter Plaintext: ")
key = input("Enter Key String: ")

l = []
i = 0
while i < len(pt)-1:
    if(pt[i]==pt[i+1]):
        pt = (pt[:i+1] + "x" + pt[i+1:])
    i+=1
if(len(pt)%2!=0):
    pt += "x"
print("\nModified Plain Text: ",pt)

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
m = []
for i in range(5):
    m.append(['.'] * 5)
i = 0
j = 0
k = 0
while k < len(key):
    if key[k] not in m[0]+m[1]+m[2]+m[3]+m[4]:
        m[i][j] = key[k]
        if j == 4:
            i += 1
        j = (j + 1) % 5
    k += 1
k = 0
while k < len(alphabet):
    if alphabet[k] not in m[0]+m[1]+m[2]+m[3]+m[4]:
        m[i][j] = alphabet[k]
        if j == 4:
            i += 1
        j = (j + 1) % 5
    k += 1
print("Matrix:\n",m)
mt = np.array(m).T.tolist()

k = 0
p = []
for i in range(int(len(pt)/2)):
    p.append([pt[k],pt[k+1]])
    k += 2
print("Pairs:\n",p)

# FUNCTION FOR ENCRYPTION & DECRYPTION
def encrypt_decrypt(p,method):
    arr = []
    for pi in range(len(p)):
        found0 = False
        found1 = False
        p0i = -1
        p0j = -1
        p1i = -1
        p1j = -1
        i = 0
        while not (found0 and found1):
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
            if method == 'e':
                arr.append([m[p0i][(p0j+1) % 5], m[p0i][(p1j+1) % 5]])
            if method == 'd':
                arr.append([m[p0i][(p0j-1) % 5], m[p0i][(p1j-1) % 5]])
        elif p0j == p1j:
            if method == 'e':
                arr.append([mt[p0j][(p0i+1) % 5], mt[p0j][(p1i+1) % 5]])
            if method == 'd':
                arr.append([mt[p0j][(p0i-1) % 5], mt[p0j][(p1i-1) % 5]])
        else:
            arr.append([m[p0i][p1j], m[p1i][p0j]])
    return arr

# ENCRYPTION
e = encrypt_decrypt(p,'e')
print("Encrypted Pairs:\n",e)
ct = ""
for i in e:
    ct+=(i[0]+i[1])
print("\nCipher Text: ",ct)

# DECRYPTION
d = encrypt_decrypt(e,'d')
print("\nDecrypted Pairs:\n",d)
dt = ""
for i in d:
    dt+=(i[0]+i[1])
print("\nDecrypted Text: ",dt)