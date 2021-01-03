# mixed-pickle

## Command messaging
### command request
{ 
  uuid: [MESSAGE_UUID], 
  from: [cuke/js/java/py/go],
  to: [cuke/js/java/py/go],
  message: {
    status: [0/1/-1],
    action: "",
    params: {}
  }
}

### command response
{
  uuid: [REQUEST_MESSAGE_UUID],
  from: [cuke/js/java/py/go],
  to: [cuke/js/java/py/go],
  message : {
    status: [0/1/-1],
    response: {}
  }
}
