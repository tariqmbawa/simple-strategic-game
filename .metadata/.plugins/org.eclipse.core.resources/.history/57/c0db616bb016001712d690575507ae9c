import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Keyboard {
        private final Key[] keys;

        public Keyboard(final Key... keys) {
            this.keys = keys.clone();
        }

        public Node createNode() {
            final HBox keyboardNode = new HBox(6);
            keyboardNode.setPadding(new Insets(6));

            final List<Node> keyboardNodeChildren = keyboardNode.getChildren();
            for (final Key key: keys) {
                keyboardNodeChildren.add(key.createNode());
            }

            installEventHandler(keyboardNode);
            return keyboardNode;
        }

        private void installEventHandler(final Parent keyboardNode) {
            // handler for key pressed / released events not handled by
            // key nodes
            final EventHandler<KeyEvent> keyEventHandler =
                    new EventHandler<KeyEvent>() {
                        public void handle(final KeyEvent keyEvent) {
                            final Key key = lookupKey(keyEvent.getCode());
                            if (key != null) {
                                key.setPressed(keyEvent.getEventType()
                                                   == KeyEvent.KEY_PRESSED);

                                keyEvent.consume();
                            }
                        }
                    };

            keyboardNode.setOnKeyPressed(keyEventHandler);
            keyboardNode.setOnKeyReleased(keyEventHandler);

            keyboardNode.addEventHandler(KeyEvent.KEY_PRESSED,
                                         new EventHandler<KeyEvent>() {
                                             public void handle(
                                                     final KeyEvent keyEvent) {
                                                 handleFocusTraversal(
                                                         keyboardNode,
                                                         keyEvent);
                                             }
                                         });
        }

        private Key lookupKey(final KeyCode keyCode) {
            for (final Key key: keys) {
                if (key.getKeyCode() == keyCode) {
                    return key;
                }
            }
            return null;
        }

        private static void handleFocusTraversal(final Parent traversalGroup,
                                                 final KeyEvent keyEvent) {
            final Node nextFocusedNode;
            switch (keyEvent.getCode()) {
                case LEFT:
                    nextFocusedNode =
                            getPreviousNode(traversalGroup,
                                            (Node) keyEvent.getTarget());
                    keyEvent.consume();
                    break;

                case RIGHT:
                    nextFocusedNode =
                            getNextNode(traversalGroup,
                                        (Node) keyEvent.getTarget());
                    keyEvent.consume();
                    break;

                default:
                    return;
            }

            if (nextFocusedNode != null) {
                nextFocusedNode.requestFocus();
            }
        }

        private static Node getNextNode(final Parent parent,
                                        final Node node) {
            final Iterator<Node> childIterator =
                    parent.getChildrenUnmodifiable().iterator();

            while (childIterator.hasNext()) {
                if (childIterator.next() == node) {
                    return childIterator.hasNext() ? childIterator.next()
                                                   : null;
                }
            }

            return null;
        }

        private static Node getPreviousNode(final Parent parent,
                                            final Node node) {
            final Iterator<Node> childIterator =
                    parent.getChildrenUnmodifiable().iterator();
            Node lastNode = null;

            while (childIterator.hasNext()) {
                final Node currentNode = childIterator.next();
                if (currentNode == node) {
                    return lastNode;
                }

                lastNode = currentNode;
            }

            return null;
        }
    }