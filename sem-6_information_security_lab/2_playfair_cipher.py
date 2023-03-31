# This program demonstrates CAESAR CIPHER.
# Only lowercase letters are allowed.
# Ex1: PT: instruments  KEY: monarchy CT: gatlmzclrqxa
# Ex2: PT: informationsecurity  KEY: playfairexample  CT: rkaseipvekokrdlcbpxg
import numpy as np
plainText = input("Enter Plaintext: ")
key = input("Enter Key String: ")

l = []
i = 0
while i < len(plainText)-1:
    if(plainText[i]==plainText[i+1]):
        plainText = (plainText[:i+1] + "x" + plainText[i+1:])
        # l.append(i)
    i+=1
if(len(plainText)%2!=0):
    plainText += "x"
    # l.append()

# Create list
l = []
alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
k = 0
while k < len(key):
    # add characters from key
    if key[k] not in l:
        l.append(key[k])
    k += 1
k = 0
while k < len(alphabet):
    # add remaining characters from  alphabet
    if alphabet[k] not in l:
        l.append(alphabet[k])
    k += 1

# Create matrix
k = 0
m = []
for i in range(5):
    m.append(l[k:k+5])
    k += 5
# print("Matrix:\n",m)
mt = np.array(m).T.tolist()

# FUNCTION FOR ENCRYPTION & DECRYPTION
def encrypt_decrypt(p,method):
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
            if method == 'e':
                arr.append([m[p0i][(p0j+1) % 5], m[p0i][(p1j+1) % 5]])
            if method == 'd':
                arr.append([m[p0i][(p0j-1) % 5], m[p0i][(p1j-1) % 5]])
            flag = False
        elif p0j == p1j:
            # same column
            if method == 'e':
                arr.append([mt[p0j][(p0i+1) % 5], mt[p0j][(p1i+1) % 5]])
            if method == 'd':
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
# print("Pairs:\n",p)

# ENCRYPTION
e = encrypt_decrypt(p,'e')
# print("Encrypted Pairs:\n",e)
ct = ""
for i in e:
    ct+=(i[0]+i[1])
print("Cipher Text: ",ct)

# DECRYPTION
d = encrypt_decrypt(e,'d')
# print("Decrypted Pairs:\n",d)
dt = ""
for i in d:
    dt+=(i[0]+i[1])
print("Decrypted Plain Text: ",dt)