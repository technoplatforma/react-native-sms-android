## react-native-sms-android

This is a react native module that sends a sms message to a phone number. There are two options for sending a sms: 1) directly inside the app or 2) outside the app by launching the default sms application. This is for android only.

For ios, you can use the LinkingIOS component which is part of the core.

To get a contact's phone number, you can use my react-native-select-contact-android module.  

## Installation

```js
npm install react-native-sms-android --save
```

## Usage Example

```js
import {Sms} from 'react-native-sms-android'

await Sms.sms(
  '123456789', // phone number to send sms to
  'This is the sms text', // sms body
);
```
