
# Overview
ZMQ broker for routing ZMQ messages. Currently only PUSH/PULL is supported.

```
                                                                            +----------------+
                                                                            |                |
        +--------------+                    +---------------+    +----->PULL| destination 1  |
        |              |                    |               |    |          |                |
        | source       |                    | broker        |    |          +----------------+
        |              |PUSH+---------->PULL|               |PUSH+                 ...
        |              |                    |               |    |          +----------------+
        +--------------+                    +---------------+    |          |                |
                                                                 +----->PULL| destination 2  |
                                                                            |                |
                                                                            +----------------+
```

To start the broker use `java -Xmx1024m -jar ch.psi.zmq.broker.jar yourConfigFile.xml`

To terminate the broker use `ctrl+c`. If it does not terminate with the first `ctrl+c` (normal shutdown) issue a second one. This will force the termination of the virtual machine.

## Configuration
The broker is configured via a xml configuration file. The content of the configuration is as follows:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<routing name="">
		<source address="tcp://localhost:8080" type="PULL"/>
		<destination address="tcp://*:9090" type="PUSH"/>
		<destination address="tcp://*:9091" type="PUB"/>
	</routing>
</configuration>
```

Curently following methods are supported for sources: PULL, SUB. PUSH and PUB are supported for destination.

You can specify (zero,) one or more destinations.

## Development
ZMQ Broker is based on https://github.com/zeromq/jeromq the Java implementation of ZMQ.

To build the broker jar use `mvn clean compile assembly:single`


#References
Main Page: http://zeromq.org/
Java Library: https://github.com/zeromq/jeromq
Education: https://learning-0mq-with-pyzmq.readthedocs.org/en/latest/pyzmq/patterns/pubsub.html
