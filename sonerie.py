import playsound, datetime
from time import sleep
from os import system
import calendar
import melodii

sound = "sunete/sonerie.mp3"
imn = "imn.mp3"



def sonerie():
	now = datetime.datetime.now()
	timeNow = str(now.hour)+':'+str(now.minute)
	imnTime = "7:58"
	playAt = ['8:0','8:50','9:0','9:50','10:0','10:50','11:10','12:0','12:10','13:0','13:10','14:0','14:10']
	
	#take current day value
	year = datetime.datetime.now().year
	month = datetime.datetime.now().month
	day = datetime.datetime.now().day
	if imnTime == timeNow:
		print("Playing imn")
		playsound.playsound(imn)
    #check if it's the right time to ring the bell
	if timeNow in playAt:
        #check if it's during the week not the weekend
		if calendar.weekday(year,month,day) < 5:
			playsound.playsound(sound)
			sleep(60)


def player():
	print("playing music")
	#see documentation on melodii.py
	song = melodii.takeASong(melodii.getFiles())
	if song in melodii.played:
		song = melodii.takeASong(melodii.getFiles())
	print("\n\n")
	print("melodii cantate")
	print(melodii.played)
	if song not in melodii.played:
		melodii.playIt(melodii.checkTime(), melodii.setTimeStamps(), song)

	if len(melodii.played) > len(melodii.getFiles()) / 3:
		played = []

	melodii.history(song)

#main loop
while True:
	sleep(1/10)
	sonerie()
	player()
