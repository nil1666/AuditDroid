AuditDroid
--------------------------
The AuditDroid Project is a fully functional and self-contained environment for learning about Android security. It's also a benchmark for testing various android app audit tool.

Introduction
--------------------------
AuditDroid requires minimal dependencies, and is ideal for both Android beginners as well as more advanced users. The project currently includes 3 parts, including Local (Storage, Component, etc.), Transfer (Https etc.), Remote (Server side) security testcase.

Description
--------------------------
There are several feature that greatly simplify usage within a training environment or for absolute beginners who want a good introduction to working with the Android platform.

As the Android SDK introduces new features, the AuditDroid contributors will strive to implement up-to-date lessons that can educate developers and security testers on new security issues. The project currently provides coverage for most of the OWASP Top 10 Mobile Risks and also includes a bunch of other problems as well.

In order to evaluate the ablility of vairous android security audit tools, AuditDroid is devised deliberately, including inter/intra-procedure, reflection etc. for the same problem.

Contributions will always be needed in order to keep this project moving at a pace that can support the seemingly endless new problems to tackle. If you are interested, please contact the project's leaders or send an email to lab.mobisec(at)gmail.com. We welcome code contributors, beta testers, new feature suggestions, and feedback always!

Project List & Description
--------------------------
>-Attack Window 
>-AutoComplete TextView\<br>  
>-Unsafe Cipher\<br>  
>-Load Apk on Sdcard\<br>  
>-Clipboard\<br>  
>-DownloadManager\<br>  
>-Command execute\<br>  
>-Unsafe Https\<br>  
>-Unsafe Log\<br>  
>-OpenFileOutPut\<br>  
>-OpenOrCreateDB\<br>  
>-Unsafe Random Number\<br>  
>-Sdcard Read\<br>  
>-Sdcard Write\<br>  
>-Unsafe SharedPreference\<br>  
>-SQL Injection\<br>  
>-Activity Expose\<br>  
>-Service Expose\<br>  
>-Receiver Expose\<br>  
>-Provider Expose\<br>  
>-Acitivity Hijacking\<br>  
>-Broadcast Hijacking\<br>  
>-Service Hijacking\<br>  
>-PendingIntent\<br>  
>-Backup\<br>  
>-Debuggable\<br>  
>-WebView\<br>  
>-WebView_FileAccess\<br>  
>-WebView_savePassword\<br>  

Naming Rule
--------------------------
Every testcase is named as (T/F)_Catagory(_I/R)_Number\<br>  
>T:the testcase should be reported as containing a bug or threat.\<br>  
>F:the testcase should NOT be reported as containing a bug or threat.\<br>  
>I:for interprocedural\<br>  
>R:for Reflection\<br>  

Evaluation (2015/10/12)
--------------------------
>1. product selected\<br>  
>>jaq (http://jaq.alibaba.com/)\<br>  
>>appscan (http://appscan.360.cn/)\<br>  
>>kingkong (http://service.security.tencent.com/kingkong)\<br>  
>>Mobei SCA (http://akana.wicp.net/android/)\<br>  
>2. false negative\<br>  
>>jaq          4.69%\<br>  
>>appscan      37.5%\<br>  
>>kingkong     40%\<br>  
>>Mobei SCA    100%\<br>  
>3. false positive\<br>  
>>jaq          3.6%\<br>  
>>appscan      16%\<br>  
>>kingkong     1.8%\<br>  
>>Mobei SCA    0\<br>  

Members
--------------------------
>owasp (www.owasp.org)\<br>  
>鲶鱼团队 (catfish team)\<br>  
>mobisec lab (www.mobiseclab.org)\<br>  
>huawei (www.huawei.com)\<br>  
>MSTG Team\<br>  
