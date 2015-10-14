AuditDroid
==========
The AuditDroid Project is a fully functional and self-contained environment for learning about Android security. It's also a benchmark for testing various android app audit tool.

Introduction
==========
AuditDroid requires minimal dependencies, and is ideal for both Android beginners as well as more advanced users. The project currently includes 3 parts, including Local (Storage, Component, etc.), Transfer (Https etc.), Remote (Server side) security testcase.

Description
==========
There are several feature that greatly simplify usage within a training environment or for absolute beginners who want a good introduction to working with the Android platform.

As the Android SDK introduces new features, the AuditDroid contributors will strive to implement up-to-date lessons that can educate developers and security testers on new security issues. The project currently provides coverage for most of the OWASP Top 10 Mobile Risks and also includes a bunch of other problems as well.

In order to evaluate the ablility of vairous android security audit tools, AuditDroid is devised deliberately, including inter/intra-procedure, reflection etc. for the same problem.

Contributions will always be needed in order to keep this project moving at a pace that can support the seemingly endless new problems to tackle. If you are interested, please contact the project's leaders or send an email to lab.mobisec(at)gmail.com. We welcome code contributors, beta testers, new feature suggestions, and feedback always!

Project List & Description
==========
* Attack Window
* AutoComplete TextView 
* Unsafe Cipher  
* Load Apk on Sdcard
* Clipboard  
* DownloadManager
* Command execute
* Unsafe Https
* Unsafe Log
* OpenFileOutPut
* OpenOrCreateDB 
* Unsafe Random Number
* Sdcard Read
* Sdcard Write
* Unsafe SharedPreference 
* SQL Injection
* Activity Expose
* Service Expose
* Receiver Expose
* Provider Expose
* Acitivity Hijacking
* Broadcast Hijacking
* Service Hijacking
* PendingIntent
* Backup
* Debuggable
* WebView
* WebView_FileAccess
* WebView_savePassword

Naming Rule
==========
Every testcase is named as (T/F)_Catagory(_I/R)_Number
* T:the testcase should be reported as containing a bug or threat.
* F:the testcase should NOT be reported as containing a bug or threat.
* I:for interprocedural
* R:for Reflection

Evaluation (2015/10/12)
==========

Product Selected
----------
* jaq (http://jaq.alibaba.com/)
* appscan (http://appscan.360.cn/)
* kingkong (http://service.security.tencent.com/kingkong)
* Mobei SCA (http://akana.wicp.net/android/)

Detection Rate
----------
* jaq          4.69%
* appscan      37.5%
* kingkong     40%
* Mobei SCA    100% 

False Positive
----------
* jaq          3.6%
* appscan      16%
* kingkong     1.8%
* Mobei SCA    0

Members
==========
* owasp (www.owasp.org)   
* 鲶鱼团队 (catfish team)
* mobisec lab (www.mobiseclab.org)
* huawei (www.huawei.com)
* MSTG Team
