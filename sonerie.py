import playsound,datetime
from time import sleep
from os import system
import calendar
songTrigger = "F:\\sonerie-si-alarme\\melodii.py"
sound = "F:\\sonerie-si-alarme\\sunete\\sonerie.mp3"
imn = "F:\\sonerie-si-alarme\\sunete\\imn.mp3"

def sonerie():
    global sound,songTrigger,imn
    now = datetime.datetime.now()
    timeNow = str(now.hour)+':'+str(now.minute)
    imnTime = "7:58"
    playAt = ['8:0','8:50','9:0','9:50','10:0','10:50','11:10','12:0','12:10','13:0','13:10','14:0','14:10']
    playSong = ['8:51','8:52','8:53','8:54','8:55','8:56','9:51','9:52','9:53','9:54','9:55','9:56','10:51','10:52','10:53','10:54','10:55','10:56','10:57','10:58','10:59','11:0','11:1','11:2','11:3','11:4','11:5','11:6','12:1','12:2','12:3','12:4','12:5','12:6','13:1','13:2','13:3','13:4','13:5','13:6','14:1','14:2','14:3','14:4','14:5','14:6']
    #take current day value
    year = datetime.datetime.now().year
    month = datetime.datetime.now().month
    day = datetime.datetime.now().day
    if imnTime == timeNow:
        print("canta imnu")
        playsound.playsound(imn)
        print("imn terminat")
    for i in playAt:
        if i == timeNow:
            if calendar.weekday(year,month,day) < 5:
                print(i,timeNow,now.second)
                playsound.playsound(sound)
                sleep(60)
        else:
            #print("Time not right",timeNow)
            pass
    for i in playSong:
        if timeNow == i:
            if calendar.weekday(year,month,day) < 5:
                print("entering melodii.py")
                system("python "+songTrigger)
while True:
    sleep(1/10)
    sonerie()
