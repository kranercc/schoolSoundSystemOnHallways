from os import walk
from playsound import playsound
import datetime,calendar
from time import sleep
mypath = 'C:\\Users\\krane\\Desktop\\\schoolSoundSystemOnHallways-master\\melodii\\'
f = []
for (dirpath, dirnames, filenames) in walk(mypath):
    f.extend(filenames)
    break
print(f)

def play():
        global f,mypath
        #code from sonerie.py
        now = datetime.datetime.now()
        timeNow = str(now.hour)+':'+str(now.minute)
        playSong = ['8:51','8:52','8:53','8:54','8:55','8:56','9:51','9:52','9:53','9:54','9:55','9:56','10:51','10:52','10:53','10:54','10:55','10:56','10:57','10:58','10:59','11:0','11:1','11:2','11:3','11:4','11:5','11:6','12:1','12:2','12:3','12:4','12:5','12:6','13:1','13:2','13:3','13:4','13:5','13:6','14:1','14:2','14:3','14:4','14:5','14:6']
        for i in f:
                for i2 in playSong:
                        if i2 == timeNow:
                                print(timeNow,timeNow,now.second)
                                playsound(mypath+i)
while True:
        sleep(1/10)
        play()
#make the songs 1,2,3,4 so i can random them insted of looping again and again same 3 songs
#every pause
