import React from "react";
import { Link } from "react-router-dom";
const Saler = (props) => {

    return (
        <div className="col-md-6 pb-4">
                    <div className="position-relative bg-secondary text-center text-md-left text-white mb-2 py-5 px-5">
                        <img src="img/offer-2.png" alt="" />
                        <div className="position-relative" style={{ zIndex: 1 }}>
                            <h5 className="text-uppercase text-primary mb-3">20% off the all order</h5>
                            <h1 className="mb-4 font-weight-semi-bold">{props.storeName}</h1>
                            <Link to={`/salers/${props.id}`}> <a href="#" className="btn btn-outline-primary py-md-2 px-md-3">Visit Shop</a></Link>
                           
                        </div>
                    </div>
                </div>
  
    );
}

export default Saler;

