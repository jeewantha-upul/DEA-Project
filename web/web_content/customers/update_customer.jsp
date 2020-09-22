<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Update Customer</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/css/sb-admin-2.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/web_content/dashboard.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-car"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Menu</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/web_content/dashboard.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseInvoice" aria-expanded="true" aria-controls="collapseInvoice">
                        <i class="fas fa-fw fa-file"></i>
                        <span>Invoice</span>
                    </a>
                    <div id="collapseInvoice" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Options:</h6>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/invoice/new_invoice.jsp">Create New Invoice</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/invoice/view_invoice.jsp">View Invoice</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/invoice/update_invoice.jsp">Update Invoice</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item active">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseCustomers" aria-expanded="true" aria-controls="collapseCustomers">
                        <i class="fas fa-fw fa-address-book"></i>
                        <span>Customers</span>
                    </a>
                    <div id="collapseCustomers" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Options:</h6>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/customers/new_customer.jsp">Add New Customer</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/customers/view_customer.jsp">View Customer</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/customers/update_customer.jsp">Update Customer</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDrivers" aria-expanded="true" aria-controls="collapseDrivers">
                        <i class="fas fa-fw fa-id-card"></i>
                        <span>Drivers</span>
                    </a>
                    <div id="collapseDrivers" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Options:</h6>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/drivers/new_driver.jsp">Add New Driver</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/drivers/view_driver.jsp">View Driver</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/drivers/update_driver.jsp">Update Driver</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseVehicles" aria-expanded="true" aria-controls="collapseVehicles">
                        <i class="fas fa-fw fa-car"></i>
                        <span>Vehicles</span>
                    </a>
                    <div id="collapseVehicles" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Options:</h6>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/vehicles/new_vehicle.jsp">Add New Vehicle</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/vehicles/view_vehicle.jsp">View Vehicle</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/vehicles/update_vehicle.jsp">Update Vehicle</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUsers" aria-expanded="true" aria-controls="collapseUsers">
                        <i class="fas fa-fw fa-user-circle"></i>
                        <span>Users</span>
                    </a>
                    <div id="collapseUsers" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Options:</h6>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/users/new_user.jsp">Add New User</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/users/view_user.jsp">View User</a>
                            <a class="collapse-item" href="${pageContext.request.contextPath}/web_content/users/update_user.jsp">Update User</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <h1 class="h1 mb-2 text-gray-900"><a href="${pageContext.request.contextPath}/web_content/dashboard.jsp"><u>Car Rental Management System</u></a></h1>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 medium"><%= session.getAttribute("first_name")%></span>
                                    <img class="img-profile rounded-circle" src="${pageContext.request.contextPath}/img/user-picture.png">
                                </a>
                            </li>
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link" href="#">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 medium"  data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </span>
                                </a>
                            </li>
                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-700">Update Customer</h1>

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Fill in the NIC to Search and Update a Customer</h6>
                                <h6 class="m-0 font-weight-bold text-primary">Keep Blank if you don't wish to change some fields!</h6>
                            </div>
                            <div class="card-body">
                                <form method="POST" action="${pageContext.request.contextPath}/UpdateDeleteCustomerServlet">
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">NIC Number</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="nic">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">First Name</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="first_name">
                                        </div>
                                        <div class="col-sm-6">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Last Name</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="last_name">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Gender</label>
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input" id="customRadio1" type="radio" name="gender" value="Male">
                                                <label class="custom-control-label" for="customRadio1">Male</label>
                                            </div>
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input" id="customRadio2" type="radio" name="gender" value="Female">
                                                <label class="custom-control-label" for="customRadio2">Female</label>
                                            </div>
                                        </div>
                                    </div>
                                    <hr>
                                    <hr>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">NIC Number</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="nic1">
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Driving License Number</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="dl_no">
                                        </div>
                                    </div>
                                    <hr>
                                    <hr>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Phone Number</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="phone_no">
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Email Address</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="email">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlInput1" class="m-0 font-weight-bold text-primary">Date of Birth</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="date" name="dob">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <label for="exampleFormControlTextarea1" class="m-0 font-weight-bold text-primary">Address</label>
                                            <input class="form-control" id="exampleFormControlInput1" type="text" name="address">
                                        </div>
                                    </div>  
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="submit" class="btn btn-success btn-user btn-block" name="action" value="Update"> 
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="submit" class="btn btn-danger btn-user btn-block" name="action" value="Delete"> 
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="reset" class="btn btn-primary btn-user btn-block" value="Clear Form"> 
                                        </div> 
                                    </div>                
                                </form>

                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; DEA Project Web Application</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/LogOutServlet">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>

    </body>

</html>
