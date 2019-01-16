import playsound,datetime
from time import sleep
sound = "sunete/alarmaDezastre.mp3"
def sonerie():
    global sound
    playsound.playsound(sound)
sonerie()
