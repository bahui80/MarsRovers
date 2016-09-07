package com.bahui.marsrovers.entities;

import com.bahui.marsrovers.helper.Point;


public enum CardinalDirection {
	N {
        @Override
        public CardinalDirection turnLeft() {
        	W.positionMovement = new Point(0, 0);
            return W;
        }

        @Override
        public CardinalDirection turnRight() {
        	E.positionMovement = new Point(0, 0);
            return E;
        }
       
        @Override
		public CardinalDirection move() {
        	N.positionMovement = new Point(0, 1);
        	return N;
        }
    },

    S {
        @Override
        public CardinalDirection turnRight() {
        	W.positionMovement = new Point(0, 0);
            return W;
        }

        @Override
        public CardinalDirection turnLeft() {
        	E.positionMovement = new Point(0, 0);
            return E;
        }
        
        @Override
        public CardinalDirection move() {
        	S.positionMovement = new Point(0, -1);
        	return S;
        }
    },

    E {
        @Override
        public CardinalDirection turnRight() {
        	S.positionMovement = new Point(0, 0);
            return S;
        }

        @Override
        public CardinalDirection turnLeft() {
        	N.positionMovement = new Point(0, 0);
            return N;
        }
        
        @Override
        public CardinalDirection move() {
        	E.positionMovement = new Point(1, 0);
        	return E;
        }
    },

    W {
        @Override
        public CardinalDirection turnRight() {
        	N.positionMovement = new Point(0, 0);
            return N;
        }

        @Override
        public CardinalDirection turnLeft() {
        	S.positionMovement = new Point(0, 0);
            return S;
        }

		@Override
		public CardinalDirection move() {
			W.positionMovement = new Point(-1, 0);
			return W;
		}
    };
    
	private Point positionMovement;
		
    public abstract CardinalDirection turnRight();    
    public abstract CardinalDirection turnLeft();
    public abstract CardinalDirection move();
    
    public Point getPositionMovement() {
    	return positionMovement;
    }
}