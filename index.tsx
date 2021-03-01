import { NativeModules } from 'react-native'

export class SmsAndroid {

  static sms = async (phone: string, body: string): Promise<boolean> => {
    return NativeModules.sms(phone, body)
  }

}
