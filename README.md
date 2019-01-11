# CircleLoader
[![](https://jitpack.io/v/MickaelCalatr/CircleLoading.svg)](https://jitpack.io/#MickaelCalatr/CircleLoading)

This is a simple circle loader library for android API 21+.

I needed to create a progress wheel on sport theme. So I created this.

This is how it looks in standard mode but you can configure it as you want.

![]demo.gif

## Dependency
You can copy the CircleLoader.java (in the library module) and the attrs.xml
content into your project. Or you can get the binaries from Maven central by
adding in your build.gradle dependencies:

### Step 1

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2
```
dependencies {
        implementation 'com.github.MickaelCalatr:CircleLoading:1.0'
}
```
## Usage
You can create your own CircleLoader in xml like this
(remember to add xmlns:app="http://schemas.android.com/apk/res-auto"):

```
    <com.mickael.circleloading.CircleLoaderView
        android:id="@+id/loading_circle"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:background="@color/color_loader"
        app:background_alpha="0.7"
        app:image_height="200dp"
        app:image_width="200dp"
        app:image_loader="@drawable/bowling_ball_1"
        app:fadeInOut_duration="500"
        app:rotate_duration="900"/>
```

To start the loading you can use:
```
CircleLoaderView loadingView = (CircleLoaderView) findViewById(R.id.loading_circle);
loadingView.startLoading();
```
 and to stop the loading use:
```
loadingView.stopLoading();
```

## Other options
In the xml definition, besides the property, you can set:
-		image_loader: reference, set a new image in the loader.
-		image_width: dimension, set the image width.
-		image_height: dimension, set the image height.
-		background_font: reference | color, set an image or a color to the background
-		background_alpha: float, set the alpha maximum to the alpha transition (0 to don't use it).
-		rotate_duration: integer, set the rotation duration.
-		translate_duration: intege, set the translation duration.
-		fadeInOut_duration: integer, set the fade in and fade out animation duration.

## Version

- 1.1 Adding function to change options programmatically
- 1.0 Initial release

## Special thanks
Icons made by <a href="https://www.freepik.com/" title="Freepik">Freepik</a>
from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="blank"> CC 3.0 BY</a>

## License
```
The MIT License (MIT)

Copyright (c) 2019 Calatraba Mickael

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
