# PV207 Customer Care in jBPM

Customer care project implemented in jBPM

### Environment Set Up
 * Java 8, 
 * Fake SMTP server running on localhost:25
 * Download [jBPM](http://www.jbpm.org/download/download.html), preferably `jBPM 6.4.0.Final-installer-full.zip`
 * `ant install.demo.noeclipse`
 * `ant start.demo.noeclipse`
 * `http://localhost:8080/jbpm-console` krisv/krisv
 * Authoring -> Administration -> Organizational Units -> Manage Organizational Units, Add -> Name: customer-care, Default Group Id: fi.muni.pv207
 * Authoring -> Administration -> Repositories -> Clone Repository -> Name: customer-care, Organizational Unit: customer-care, Git URL: url to this repository
 * After these steps project should be available in Project Authoring tab.

Some useful commands
```
ant stop.demo
# note: it deletes all cloned repositories
ant clean.demo
```
#### Pull changes from remote to jBMP
```
git clone <jbmp/.niogit/foo.git>
cd foo
git remote add gh <github url>
git pull gh <branch>
git push #pushes changes back to jBPM
```
This can be also used for synchronizing changes between IDE and jBPM
