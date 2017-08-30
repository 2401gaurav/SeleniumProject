Sleep (5000)
$title = WinGetTitle("[ACTIVE]") ; retrives whole window title
$UN=WinGetText($title,"User Name:")
$PWD=WinGetText($title,"Password:")
ControlSend($title,"",$UN,"amruta.shanbhag");Sets Username
Sleep (5000)
Send("{TAB}")
ControlSend($title,"",$PWD,"Mobiel@123");Sets PWD
Sleep (5000)
Send("{ENTER}")