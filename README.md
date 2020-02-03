# WoTnectivity
WoTnectivity ecosystem parent project. This project offers an interface to help implement a WoTnectivity protocol to add to the WoTnectivity ecosystem.

Java library to connect to different communication protocols of IoT devices.

## Install instructions

If you want to compile your own source code, you will need to add the generated .jar to the local mvn repository.

```console
foo@bar:~$ mvn install:install-file "-Dfile=wotnectivity-0.0.1-ALPHA-SNAPSHOT.jar" "-DgroupId=es.ual.acg" "-DartifactId=wotnectivity" "-Dversion=0.0.1-ALPHA-SNAPSHOT" "-Dpackaging=jar"
```

After installing it into the maven repository the only thing that you have to do in order to implement a new library protocol is to add the necessary dependency and implement the interface IRequester in the corresponding class.

```xml
<dependency>
    <groupId>es.ual.acg</groupId>
    <artifactId>wotnectivity</artifactId>
    <version>0.0.1-ALPHA-SNAPSHOT</version>
</dependency>
```


## Supported Protocols

### HTTP

The source code, releases and the help can be found in:

+ [https://github.com/acgtic211/wotnectivity-http](https://github.com/acgtic211/wotnectivity-http).

### WebSocket

The source code, releases and the help can be found in:

+ [https://github.com/acgtic211/wotnectivity-ws](https://github.com/acgtic211/wotnectivity-ws).

### KNX

The source code, releases and the help can be found in:

+ [https://github.com/acgtic211/wotnectivity-knx](https://github.com/acgtic211/wotnectivity-knx).

## Collaborators

* **Manel Mena** -  [https://github.com/manelme](https://github.com/manelme).

* **Javier Criado** -  [https://github.com/javicriado](https://github.com/javicriado).

* **Luis Iribarne** -  [https://w3.ual.es/~liribarn/](https://w3.ual.es/~liribarn/).

* **Antonio Corral** -  [https://github.com/ualacorral](https://github.com/ualacorral).


## Acknowledgements
This work was funded by the EU ERDF and the Spanish MINECO under Project [TIN2017-83964-R](http://acg.ual.es/projects/cosmart/) and the regional project (ref. CEIJ-C01.2) coordinated from UAL-UCA universities and funded by the CEIMAR consortium. Manel Mena has been funded by a grant of the Spanish Government FPU17/02010.
