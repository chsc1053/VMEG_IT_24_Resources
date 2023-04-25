# This program demonstrates CAESAR CIPHER.
# Only uppercase, lowercase letters & spaces are allowed.
plainText = input("Enter a string: ")
key = 3

# Encryption
cipherText = ""
for i in plainText:
    if i == " ":
        cipherText += " "
        continue
    if 97 <= ord(i):
        p = ord(i)-97
        c = (p + key) % 26
        cipherText += chr(c+97)
    else:
        p = ord(i)-65
        c = (p + key) % 26
        cipherText += chr(c+65)
print("Encrypted Text: ",cipherText)

# Decryption
decryptedText = ""
for i in cipherText:
    if i == " ":
        decryptedText += " "
        continue
    if 97 <= ord(i):
        p = ord(i)-97
        c = (p - key) % 26
        decryptedText += chr(c+97)
    else:
        p = ord(i)-65
        c = (p - key) % 26
        decryptedText += chr(c+65)
print("Decrypted Text: ",decryptedText)