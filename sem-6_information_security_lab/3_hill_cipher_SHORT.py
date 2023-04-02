import numpy as np
import scipy as sp
plainText = input("Enter Plaintext: ")
key = input("Enter Key String: ")

# Creating key matrix
kms = 1 # key matrix size
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

# ENCRYPTION
cipherText = ""
k = 0
while k < len(plainText):
	# creating plain text matrix
	ptm = []
	for i in range(kms):
		ptm.append([ord(plainText[k+i]) - 97])

	# multiplying key matrix with plain text matrix to get cipher text matrix: ctm = (km * ptm) % 26
	ctm = np.matmul(km,ptm) % 26
	for i in range(kms):
		cipherText = cipherText + chr(ctm[i][0] + 97)
	k += kms
print("\nCipher Text: ",cipherText)


# DECRYPTION
decryptedText = ""
k = 0

# determinant
d = int(sp.linalg.det(km))
# inverse of determinant
di = 1
while((d*di)%26 != 1):
	di += 1

# inverse of key matrix
kmi = sp.linalg.inv(km)
for i in range(len(kmi)):
	for j in range(len(kmi[i])):
		kmi[i][j] = kmi[i][j] * d * di

while k < len(cipherText):
	# creating cipher text matrix
	ctm = []
	for i in range(kms):
		ctm.append([ord(cipherText[k+i]) - 97])
	
	# multiplying inverse of key matrix with cipher text matrix to get plain text matrix: dtm = (kmi * ctm) % 26
	dtm = np.matmul(kmi,ctm) % 26
	for i in range(kms):
		decryptedText = decryptedText + chr((int(dtm[i][0]) % 26) + 97)
	k += kms
print("\nDecrypted Text: ",decryptedText)