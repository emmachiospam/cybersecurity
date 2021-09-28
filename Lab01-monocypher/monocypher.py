from collections import Counter
test = input ("here: ")
test1 = test.lower()
a = [char for char in test1]
c = Counter(a)
print(c)
