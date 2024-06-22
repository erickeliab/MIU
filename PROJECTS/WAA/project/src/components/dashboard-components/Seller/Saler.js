import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const DashSaler = (props) => {
    const [approval, setApproved] = useState(props.approval);

    const handleApprove = async () => {
        try {
            const response = await axios.post('http://localhost:8081/api/admin/approve-seller/'+props.id, {
                id: props.id,
                approved: true
            });
            if (response.data.approved) {
                setApproved(true);
            }
        } catch (error) {
            alert("There was an error approving the seller!", error);
        }
    };

console.log(props)
    return (
        <tr>
            <td>{props.id}</td>
           
            <td>{props.name}</td>
            <td>{props.email}</td>
            <td>{props.phoneNumber}</td>
            <td>{props.username}</td>
            <td>

                {approval === true ? <span className="badge badge-success">Approved</span> : <span className="badge badge-warning">Pending</span>}
               
            </td>
            <td>{props.createdAt?.substring(0, 10)}</td>
            <td>

            {approval === true ? <></>: <button className="btn btn-primary btn-sm m-1" onClick={handleApprove}>Approve</button>}
            
             
                <button className="btn btn-success btn-sm">Details</button>
            </td>
        </tr>
    );
}

export default DashSaler;
