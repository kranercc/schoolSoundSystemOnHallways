from os import walk
from playsound import playsound
mypath = 'C:\\Users\\INFO\\Desktop\\sonerie si alarme\\melodii'
f = []
for (dirpath, dirnames, filenames) in walk(mypath):
    f.extend(filenames)
    break
print(f)
for i in f:
        playsound("melodii\\%s" % i)
