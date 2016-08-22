package lab02;

/**
 * Factory than creates some kinds of triangkes
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.1
 */
public class TriangleFactory {

	public TriangleRoot newTriangle(int triangleKind) {
		switch (triangleKind) {
		case 1:
			return new TriangleSideAndHeight( MsgConsts.MSG_MENU_LEVEL1_1.toString() );
		case 2:
			return new TriangleThreeSides( MsgConsts.MSG_MENU_LEVEL1_2.toString() );
		case 3:
			return new TriangleTwoSidesAndAngle( MsgConsts.MSG_MENU_LEVEL1_3.toString() );
		default:
			return null;
		}
	} 
}
