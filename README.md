# kotlin_easy_wpp
Send WhatsApp messages to numbers not saved in your contacts. Supports a reusable default message, a “Use default message” checkbox, and a Clear button that resets fields (except the default message).


# WhatsApp Fácil (Easy_WPP)

A tiny utility to start WhatsApp chats with phone numbers **not** saved in your contacts.  
It lets you set a reusable **default message**, toggle it on/off via a **“Use default message”** checkbox, and quickly reset inputs with a **Clear** button (which keeps your default message intact).

> **Not affiliated with WhatsApp or Meta.**

---

## Features
- **Message unsaved numbers:** Open a chat with any valid number.
- **Default message:** Save a message to reuse; only the recipient’s number changes.
- **“Use default message” checkbox:** When checked, the default message is used for sending.
- **Clear button:** Clears all input fields **except** the default message.

---

## How it works
The app builds a WhatsApp deep link for the number you provide and opens WhatsApp with your message pre-filled.

---

## Usage
1. Enter the phone number with **DDD (area code) + number** (only digits, no spaces/symbols).
2. *(Optional)* Write your **default message**.
3. **Check** the box **“Use default message”** if you want to send the saved default message.  
   - ✅ Checked ➜ the app uses your default message.  
   - ❌ Unchecked ➜ the app uses the message you typed in the regular message field (if present).
4. Tap **Send** to open WhatsApp with the message prefilled.
5. Tap **Clear** to reset all fields **except** the default message.

---

## Notes & Tips
- Make sure the number includes the **DDD (area code)** before sending.
- If WhatsApp is not installed, your device may open **WhatsApp Web** instead.
- The app **does not auto-send**; it opens WhatsApp with the chat/message ready.

---

##Privacy

No contacts are read or modified.

No messages are stored or sent by the app itself; it only passes data to WhatsApp.

---

##Disclaimer

This project is an independent utility and is not endorsed by or associated with WhatsApp/Meta.
Use responsibly and follow WhatsApp’s Terms of Service and local regulations.

