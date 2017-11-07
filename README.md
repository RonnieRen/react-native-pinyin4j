
# react-native-pinyin4j

## Getting started

`$ npm install react-native-pinyin4j --save`

### Mostly automatic installation

`$ react-native link react-native-pinyin4j`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-pinyin4j` and add `RNPinyin4j.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPinyin4j.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPinyin4jPackage;` to the imports at the top of the file
  - Add `new RNPinyin4jPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-pinyin4j'
  	project(':react-native-pinyin4j').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-pinyin4j/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-pinyin4j')
  	```

#### Windows

  to do later :)


## Usage
```javascript
import RNPinyin4j from 'react-native-pinyin4j';

// TODO: What to do with the module?
RNPinyin4j.getHanyuPinyinStringArray(hanzi).then((pinyins: string[]) => {
  console.log(pinyins[0]);
})
.catch(error => {
  console.log(error);
})
```
  
