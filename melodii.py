from os import walk,system
from playsound import playsound
import datetime,calendar
from time import sleep
from random import randint

mypath = "melodii/"

def getFiles():
	#store name of files ( eg: 1.mp3 )
	f = []
	for (dirpath, dirnames, filenames) in walk(mypath):
		f.extend(filenames)
		break
	return f

# OLD 
# time to play songs at
#playSong = ['8:51','8:52','8:53','8:54','8:55','8:56','9:51','9:52','9:53','9:54','9:55','9:56','10:51','10:52','10:53','10:54','10:55','10:56','10:57','10:58','10:59','11:0','11:1','11:2','11:3','11:4','11:5','11:6','12:1','12:2','12:3','12:4','12:5','12:6','13:1','13:2','13:3','13:4','13:5','13:6','14:1','14:2','14:3','14:4','14:5','14:6']

def setTimeStamps():
	# New
	schoolTime = ['8','9','10','11','12','13','14']
	playAt = []

	for h in schoolTime:
		#playsong becomes [8.51,8.52 etc] until  8.56 which gives 6 minutes of music to play
		if int(h) < 11:
			for i in range(1,7):
				playAt.append(h+':5%s' % i)
		# playsong becomes [11.1, 11.2 .. 11.6]
		if int(h) > 11:
			for i in range(1,7):
				playAt.append(h+':%s' % i)
	#debug
	print(playAt)
	return playAt



#use it like so takeASong(getFiles(), path)
def takeASong(f):
	chosen = randint(1,len(f))
	song = str(chosen)+'.mp3'
	#debug
	print("Song: ", song)
	return song




def checkTime():
	now = datetime.datetime.now()
	timeNow = str(now.hour)+':'+str(now.minute)
	#debug
	print("Time now: ",timeNow)
	return timeNow



# use it like so playIt(setTimeStamps(), checkTime(), takeASong())
def playIt(timeNow, breakTime,song):
	#check to see if the time now is in the time stamps it's requierd to play a song at
	if timeNow in breakTime:
		print("Song playing: ", song)
		playsound(mypath+str(song))
	else:
		print("Song not playing", song)
		print(timeNow,breakTime[0])
		print(type(timeNow),type(breakTime[0]))

	return song


'''
playIt should check history for songs played 
before playing one

to run it should be

song = takeASong(getFiles())
history(song)

if song in history:
	song = takeASong(getFiles())

if song not in history:
	playIt(checkTime(), setTimeStamps(), song)

if len(played) > getFiles() / 3: ### don't force processor to squiz the last 1/3 songs left in the playlist, give them another chance some other time
	played = []
'''
played = []
def history(songPlayed):
	played.append(songPlayed)



if __name__ == "__main__":
	playIt(checkTime(), setTimeStamps(), takeASong(getFiles()))
