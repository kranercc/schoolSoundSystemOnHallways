from os import walk
from playsound import playsound
mypath = 'C:\\Users\\krane\\Desktop\\\schoolSoundSystemOnHallways-master\\melodii\\'
f = []
for (dirpath, dirnames, filenames) in walk(mypath):
    f.extend(filenames)
    break
print(f)
for i in f:
        playsound(mypath+i)
