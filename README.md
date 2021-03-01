## react-native-sms-android

This is a react native module that sends a sms message to a phone number.

## Installation

```js
yarn add react-native-sms-android
```

## Usage Example

```js
import {Sms} from 'react-native-sms-android'

await Sms.sms(
  '123456789', // phone number to send sms to
  'This is the sms text', // sms body
);
```
