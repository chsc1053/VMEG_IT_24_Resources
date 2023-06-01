import math

p = 3
q = 11
print("p =", p, ", q = ", q)

n = p*q
print("n =", n)
 
phi = (p-1)*(q-1)
 
e = 2
while(math.gcd(e, phi) != 1 and e<phi):
    e += 1
print("e =", e)

d = 1
while((d*e)%phi != 1):
    d = d+1
print("d =", d)
 
msg = 2
print('Original message:',msg)
 
ct = pow(msg, e)
ct = math.fmod(ct, n)
print('Encrypted message:', ct)
 
dt = pow(ct, d)
dt = math.fmod(dt, n)
 
print('Decrypted message:', dt)