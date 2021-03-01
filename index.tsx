import { NativeModules, Linking, Platform } from 'react-native'

export class Sms {

  static sms = async (phone: string, body: string): Promise<boolean> => {
    if (Platform.OS === 'ios') {
      Linking.openURL(`sms:&addresses=${phone}&body=${body}`)
      return true
    }
    return NativeModules.SmsAndroid.sms(phone, body)
  }

}
