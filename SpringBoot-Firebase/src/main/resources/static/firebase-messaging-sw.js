
// Import the functions you need from the SDKs you need
// import { initializeApp } from "https://www.gstatic.com/firebasejs/9.6.9/firebase-app.js";
// import { getAnalytics } from "https://www.gstatic.com/firebasejs/9.6.9/firebase-analytics.js";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
importScripts("https://www.gstatic.com/firebasejs/9.1.3/firebase-app-compat.js");
importScripts("https://www.gstatic.com/firebasejs/9.1.3/firebase-messaging-compat.js");

firebase.initializeApp({
    apiKey: "AIzaSyDkefT-j8-NypDFp4S7D_JIzSzGC-f9WTQ",
    authDomain: "pushdemo-c42aa.firebaseapp.com",
    databaseURL: "https://pushdemo-c42aa.firebaseio.com",
    projectId: "pushdemo-c42aa",
    storageBucket: "pushdemo-c42aa.appspot.com",
    messagingSenderId: "437398191742",
    appId: "1:437398191742:web:d36057658b6b28efb5a22f",
    measurementId: "G-8P9HW2GN8P"
});

const messaging = firebase.messaging();

// Initialize Firebase
// const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);
// </script>