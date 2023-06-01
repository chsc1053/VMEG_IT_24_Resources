# pip install pycryptodome
from Crypto.Cipher import AES

key = b'helloworld123456'
plain_text = b'Python is the Best Language!'
print("Plain text:", plain_text)

def pad(text):
    n = len(text) % 8
    return text + (b' ' * n)

padded_text = pad(plain_text)

aes = AES.new(key, AES.MODE_ECB)

encrypted_text = aes.encrypt(padded_text)
print("Cipher text:", encrypted_text)

decrypted_text = aes.decrypt(encrypted_text)
print("Decrypted text:", decrypted_text)