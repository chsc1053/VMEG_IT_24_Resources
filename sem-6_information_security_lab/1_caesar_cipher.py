s = input("Enter a string to encrypt: ")
k = 3
ki = input("Enter key (default = 3 [Press Enter]): ")
if ki!="":
  k = int(ki)
for i in s:
    if i==" ":
       print(" ",end="")
       continue
    p = ord(i)-97
    c = (p + k)%26
    print(chr(c+97),end="")
print()