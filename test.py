plaintext = input("Please enter your plaintext: ")
shift = input("Please enter your key: ")
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
ciphertext = ""

while isinstance(int(shift), int) == False:
  shift = input("Please enter your key (integers only!): ")

shift = int(shift)
new_ind = 0

for i in plaintext:
  if i in alphabet:
    new_ind = alphabet.index(i) - shift
    # print(new_ind)
    ciphertext += alphabet[new_ind % 26]
  else:
    ciphertext += i
print("The ciphertext is: " + ciphertext)