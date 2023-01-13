# OOSE_Document_Editor
A teamwork of OOSE courses for partial Java implementation of the Lexi Editor from the book Design Patterns by the GoF.

## Key Functionality
- Can write characters on the app and insert images using the menu item.
- Can save and open document.
- Can use default styles and custom style.
- Color and background color is changeable.
- Allowing change font style to bold, italic and underlined.

## Design Pattens Implemented
- Composite Pattern has been used to create a Glyph hierarchy such as Paragraph, Image, and Characters.
- Strategy Pattern provides different fonts to change.
- Decorate Pattern has been used to create decorator glyph like Bold, Italic, FontColor, etc.
- Abstract Factory was used to create different style of widgets which are Linux and Windows.
- Iterator Pattern has been used to design our own storage structure and iterator.
- Visitor Pattern for visiting each Glyphs inside the Root Glyph to format the document and count the numbers and characters.
- Builder Pattern builds normal mode, only text mode and protection mode.
- State Patten handles three types of states, initial, working and sleeping state.
- Command Pattern for copying, cutting and pasting word.
- Memento Pattern provides functions of undo and redo.
- Flyweight Pattern provides three default styles and custom style.
## Technology Stack
Java, Swing
