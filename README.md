# test-jms

## Introduction

The Java Message Service (JMS) API is a Java message-oriented middleware API for sending messages between two or more clients.

Here is some code to do a single test with ActiveMQ and WebSphere MQ.

I'll show how to install and quickly use ActiveMQ, but I'll not show how to install WebSphere MQ.

## ActiveMQ

### Linux/Mac OS X Daemon

Here are the steps to setup ActiveMQ:

1. Download the linux/unix binary distribution (i.e. apache-activemq-5.15.8.tar.gz)
2. Extract the files from the gzip file into your HOME directory.
3. Update .bash_profile to include ActiveMQ:

    export ACTIVEMQ_HOME=/Users/domiq44/apache-activemq-5.15.8
    export PATH=$ACTIVEMQ_HOME/bin/macosx:$PATH 

Here are the steps to run the ActiveMQ broker as a daemon in Linux or Unix systems:

1. Run activemq start
 
 To stop the daemon process:
 
1. Run activemq stop

### Windows Service

Here are the steps to setup ActiveMQ:

1. Download the linux/unix binary distribution (i.e. apache-activemq-5.15.8.zip)
2. Extract the files from the zip file into the place you want..
3. Update environment variable to include ActiveMQ:

    ACTIVEMQ_HOME=\the\place\you\choose\apache-activemq-5.15.8
    PATH=%ACTIVEMQ_HOME%\bin\win64
    
Here are the steps to run the ActiveMQ broker as a service:

1. Run InstallService.bat
 
 To stop the daemon process:
 
1. Run UninstallService.bat

## Demo

1. Run JMSListerners
2. Run ClientJMS
