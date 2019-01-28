import React from "react";
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  NativeModules
} from "react-native";
const { NavigateModule } = NativeModules;

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, React native</Text>
        <TouchableOpacity
          style={{
            height: 30,
            width: 100,
            borderRadius: 5,
            backgroundColor: "blue",
            justifyContent: "center",
            alignItems: "center"
          }}
          onPress={() => {
            NavigateModule.navigate();
          }}
        >
          <Text style={{ color: "#ccc" }}>Quay lại</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center"
  },
  hello: {
    fontSize: 20,
    textAlign: "center",
    margin: 10
  }
});

AppRegistry.registerComponent("MyReactNativeApp", () => HelloWorld);
