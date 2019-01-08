# emobility-deviceconn
An application that receives data from eBike. Makes via an HTTP server.

Table of contents
=================
  * [Requirements](#requirements)
  * [Run](#run)
  * [Test](#test)
  * [Pprof](#pprof)




Requirements
=================
This project requires go version 1.11.2 or higher. <br><br>
package: emobility-deviceconn<br>
import:
- package: github.com/Shopify/sarama<br>
  version: ~1.20.0<br>
- package: github.com/alecthomas/template<br>
- package: github.com/garyburd/redigo<br>
  version: ~1.6.0<br>
  subpackages:<br>
  - redis<br>
- package: github.com/getsentry/raven-go<br>
  version: ~0.2.0<br>
- package: github.com/gojektech/heimdall<br>
  version: ~5.0.2<br>
  subpackages:<br>
  - hystrix<br>
- package: github.com/labstack/echo<br>
  version: ~3.3.8<br>
  subpackages:<br>
  - middleware<br>
- package: github.com/op/go-logging<br>
  version: ~1.0.0<br>
- package: github.com/spf13/viper<br>
  version: ~1.3.1<br>
- package: github.com/swaggo/echo-swagger<br>
- package: github.com/swaggo/swag<br>
  version: ~1.4.0<br>
- package: github.com/teris-io/shortid<br>
  version: ~1.0.0<br>
testImport:<br>
- package: github.com/stretchr/testify<br>
  version: ~1.2.2<br>
  subpackages:<br>
  - assert<br>



Run
=================
emobility-deviceconn --env=development<br>
emobility-deviceconn --env=production

Test
=================
go test -bench=. -benchmem=true -run=none<br>
go test -v

Pprof
=================
go tool pprof emobility-deviceconn http://localhost:8888/debug/pprof/profile<br>
go tool pprof emobility-deviceconn http://localhost:8888/debug/pprof/heap
