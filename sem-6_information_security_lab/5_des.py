# pip install pycryptodome
from Crypto.Cipher import DES

key = b'hello123'
plain_text = b'Python is the Best Language!'
print("Plain text:", plain_text)

def pad(text):
    n = len(text) % 8
    return text + (b' ' * n)

padded_text = pad(plain_text)

des = DES.new(key, DES.MODE_ECB)

encrypted_text = des.encrypt(padded_text)
print("Encrypted text:", encrypted_text)

decrypted_text = des.decrypt(encrypted_text)
print("Decrypted text:", decrypted_text)