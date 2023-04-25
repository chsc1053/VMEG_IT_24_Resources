import numpy as np
import scipy as sp
pt = input("Enter Plaintext: ")
key = input("Enter Key String: ")

kms = 1
while kms*kms != len(key):
    kms += 1
l = []
k = 0
while k < len(key):
	l.append(int(key[k]))
	k += 1
km = []
k = 0
while k < len(key):
	km.append(l[k:k+kms])
	k += kms
print("Key Matrix: \n",km)

print("\nENCRYPTION\n")
ct = ""
k = 0
while k < len(pt):
	ptm = []
	for i in range(kms):
		ptm.append([ord(pt[k+i]) - 97])
	print("PlainText matrix",int(k/kms),":\n",ptm)

	ctm = np.matmul(km,ptm) % 26
	print("CipherText matrix",int(k/kms),":\n",ctm)
	for i in range(kms):
		ct = ct + chr(ctm[i][0] + 97)
	k += kms
print("\nCipher Text: ",ct)


print("\nDECRYPTION\n")
dt = ""
k = 0

d = int(sp.linalg.det(km))
print("Determinant: ",d)

di = 1
while((d*di)%26 != 1):
	di += 1
print("Inverse of determinant: ",di)

kmi = sp.linalg.inv(km)
for i in range(len(kmi)):
	for j in range(len(kmi[i])):
		kmi[i][j] = kmi[i][j] * d * di
print("Inverse of key matrix:\n",kmi)

while k < len(ct):
	ctm = []
	for i in range(kms):
		ctm.append([ord(ct[k+i]) - 97])
	print("CipherText matrix",int(k/kms),":\n",ctm)
	
	dtm = np.matmul(kmi,ctm) % 26
	print("DecryptedText matrix",int(k/kms),":\n",dtm)
	for i in range(kms):
		dt = dt + chr((int(dtm[i][0]) % 26) + 97)
	k += kms
print("\nDecrypted Text: ",dt)