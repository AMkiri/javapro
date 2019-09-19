package skillbox.amkiri.module5.hw4;

class Command {
    private CommandType type;
    private String text;

    enum CommandType {
        LIST,
        NAME,
        PHONE,
        EXIT
    }

    Command(CommandType type, String text) {
        this.type = type;
        this.text = text;
    }

    CommandType getType() {
        return type;
    }

    String getText() {
        return text;
    }
}
