# VolleySimple
[![](https://jitpack.io/v/hosamazzam/VolleySimple.svg)](https://jitpack.io/#hosamazzam/VolleySimple)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/hosamazzam/VolleySimple/issues)
## Synopsis

VolleySimple is library that support simplest use of Main Volley lib provided by google.

## Motivation

sometime you want to make clean code with less lines of code so i start from this point to provide.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Installing

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file (Gradle)

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
  
Step 2. Add the dependency in app/build.gradle

	dependencies {
	        compile 'com.github.hosamazzam:VolleySimple:v1.0.0'
	}

## Built With

* [Gradle](https://gradle.org/) - Build Tool
* [JitPack](https://jitpack.io/) - Publish your JVM and Android libraries

## Code Examples

[asyncStringGet]

```
VolleySimple.getInstance(this).asyncStringGet("your url", new VolleySimple.NetworkListener<String>() {
            @Override
            public void onResponse(String response) {
            }

            @Override
            public void onFailure(Exception e) {
            }
        });
```

[asyncImageGet] 

```
VolleySimple.getInstance(this).asyncImageGet("your url", new VolleySimple.ImageListener() {
            @Override
            public void onResponse(Bitmap bitmap) {
            }

            @Override
            public void onFailure(Exception e) {
            }
        });
```


## Supported
* String Request ( GET , POST).
* JsonObject Request ( GET , POST).
* JsonArray Request ( GET , POST).
* Async and sync requests (sync should Not use in UI main Thread).
* Image Downloaded.
* Singleton queue provided.
* Default progress dialog can use or your owned dialog.


## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

