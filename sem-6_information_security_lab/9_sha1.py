# Python 3 code to demonstrate SHA hash algorithms.
import hashlib

# initializing string
pt = "Vardhaman"
print("Plain text : ", pt)

# encoding string using encode()
encoded_pt = pt.encode()

# applying SHA1() on encoded text
ct = hashlib.sha1(encoded_pt)

# printing the message digest.
print("Message Digest : ", ct.digest())

# printing the equivalent hexadecimal value of message digest.
print("Message Digest in Hexadecimal: ", ct.hexdigest())