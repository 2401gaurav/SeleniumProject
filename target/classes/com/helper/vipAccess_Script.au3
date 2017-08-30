Local $iPID = Run("VIPUIManager.exe")
    Sleep(5000)
     WinActivate("VIP Access")
	  Local $hIE = WinGetHandle("[Class:#32770]")
  Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:]")
    ;This function will click the button on the VIP Access to copy the Security Code.
    ;MouseClick("left", 1254, 903)
	 MouseClick("left",1253,600,1)

	Sleep(6000)
	;ControlSend($hIE ,"",$hCtrl,"{TAB}")
	Send("{TAB}")
	Send("{enter}")
    ControlClick("VIP Access", "", "Button5", "left")
    	Sleep(2000)
	  Local $hIE = WinGetHandle("[Class:Chrome_WidgetWin_1]")
  Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:Chrome_RenderWidgetHostHWND1]")

 ; Sleep(5000)
	WinActivate("ESO Symantec VIP - Google Chrome")
	 ControlClick($hIE ,"",$hCtrl,"left")          ; Gives focus to Open Button
; ControlSend($hIE ,"",$hCtrl,"{TAB}")
MouseClick("left",534,446,1)

	    Sleep(100)
		Send("^v")

		 Sleep(100)
		Send("{enter}")

 Sleep(1000)
		MouseClick("left",749,632,1)

WinActivate("VIP Access")
ProcessClose($iPID)

