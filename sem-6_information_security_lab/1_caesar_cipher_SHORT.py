pt = input("Enter a string: ")
key = 3

# Encryption
ct = ""
for i in pt:
    if i == " ":
        ct += " "
        continue
    if 97 <= ord(i):
        p = ord(i)-97
        c = (p + key) % 26
        ct += chr(c+97)
    else:
        p = ord(i)-65
        c = (p + key) % 26
        ct += chr(c+65)
print("Encrypted Text: ",ct)

# Decryption
dt = ""
for i in ct:
    if i == " ":
        dt += " "
        continue
    if 97 <= ord(i):
        p = ord(i)-97
        c = (p - key) % 26
        dt += chr(c+97)
    else:
        p = ord(i)-65
        c = (p - key) % 26
        dt += chr(c+65)
print("Decrypted Text: ",dt)