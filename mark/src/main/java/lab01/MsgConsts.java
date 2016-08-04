package lab01;

/**
 * String constants container for output
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public enum MsgConsts {
    MSG_FINAL_WORD {
        public String toString() {
            return "Exit commant entered. Closing...";
        }
    },
    MSG_CYCLE_PROMPT {
        public String toString() {
            return "Enter account name: ";
        }
    },
    MSG_HEAD1 {
        public String toString() {
            return "Wellcome to account check program.\nEnter account name or ";
        }
    },
    MSG_HEAD2 {
        public String toString() {
            return "for exit\n\n";
        }
    },
    MSG_ACCOUNT_IS_VALID {
        public String toString() {
            return "OK\n";
        }
    },
    MSG_ACCOUNT_NOT_FOUND_EXCEPTION {
        public String toString() {
            return "AccountNotFoundException: Account was not found\n";
        }
    },
    MSG_ACCOUNT_FORMAT_EXCEPTION {
        public String toString() {
            return "AccountFormatException: Account should not contain non-numeric characters\n";
        }
    }
}
